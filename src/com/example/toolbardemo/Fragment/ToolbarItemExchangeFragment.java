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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.toolbardemo.MainActivity;
import com.example.toolbardemo.R;

/**
 * The ToolbarItemExchangeFragment represents
 * @version $Id$
 * @author wangqingyi
 * @datetime Apr 13, 2015 4:19:24 PM
 */
public class ToolbarItemExchangeFragment extends Fragment {

	private MainActivity activity;
	private Button changeBtn;

	/**
	 * {@inheritDoc}
	 * @see android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		activity = (MainActivity) getActivity();
	}

	/**
	 * {@inheritDoc}
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_item_exchange, container, false);
		findViews(v);
		return v;
	}

	private void findViews(View v) {
		changeBtn = (Button) v.findViewById(R.id.changeButton);
		changeBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				activity.show(v);
			}
		});
	}
}
