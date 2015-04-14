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
import android.view.ViewGroup;

import com.example.toolbardemo.R;

/**
 * The RippleDrawable represents
 * @version $Id$
 * @author wangqingyi
 * @datetime Apr 13, 2015 5:50:34 PM
 */
public class AnimDrawableFragment extends Fragment {

	/**
	 * {@inheritDoc}
	 * @see android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

	/**
	 * {@inheritDoc}
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_anim_drawable, container, false);
	}

}
