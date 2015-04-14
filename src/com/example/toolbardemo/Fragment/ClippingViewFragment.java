/*
 * Copyright © 2015 Pandabus Ltd., All Rights Reserved.
 * For licensing terms please contact Pandabus LTD.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.toolbardemo.Fragment;

import android.graphics.Outline;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.TextView;

import com.example.toolbardemo.R;

/**
 * The ClippingViewFragment represents
 * @version $Id$
 * @author wangqingyi
 * @datetime Apr 14, 2015 4:56:41 PM
 */
public class ClippingViewFragment extends Fragment {

	private TextView tv2, tv1;

	/**
	 * {@inheritDoc}
	 * @see android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		tv1 = (TextView) getActivity().findViewById(R.id.tv_1);
		tv2 = (TextView) getActivity().findViewById(R.id.tv_2);
		clippingView();
	}

	private void clippingView() {
		ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {

			@Override
			public void getOutline(View view, Outline outline) {

				outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 10);
			}
		};
		ViewOutlineProvider viewOutlineProvider1 = new ViewOutlineProvider() {

			@Override
			public void getOutline(View view, Outline outline) {

				outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), view.getHeight() / 2);
			}
		};
		tv1.setOutlineProvider(viewOutlineProvider);
		tv2.setOutlineProvider(viewOutlineProvider1);
	}

	/**
	 * {@inheritDoc}
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_clipping_view, container, false);
	}

}
