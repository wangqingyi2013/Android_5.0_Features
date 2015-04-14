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

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.toolbardemo.MainActivity;
import com.example.toolbardemo.R;

/**
 * The MenuFragment represents
 * @version $Id$
 * @author wangqingyi
 * @datetime Apr 13, 2015 4:29:33 PM
 */
public class MenuFragment extends Fragment implements OnClickListener {

	private MainActivity mainAct;
	private View mFragmentContainerView;
	private DrawerLayout mDrawerLayout;
	private NavigationDrawerCallbacks mCallbacks;
	private TextView item0, item1, item2;

	/**
	 * Callbacks interface that all activities using this fragment must implement.
	 */
	public static interface NavigationDrawerCallbacks {

		/**
		 * Called when an item in the navigation drawer is selected.
		 */
		void onNavigationDrawerItemSelected(int position);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mainAct = (MainActivity) activity;
			mCallbacks = (NavigationDrawerCallbacks) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
		}
	}

	/**
	 * {@inheritDoc}
	 * @see android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);
		mainAct = (MainActivity) getActivity();
	}

	/**
	 * {@inheritDoc}
	 * @see android.support.v4.app.Fragment#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	/**
	 * {@inheritDoc}
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_menu, container, false);
		initItems(v);
		return v;
	}

	/**
	 * Users of this fragment must call this method to set up the navigation drawer interactions.
	 * @param fragmentId The android:id of this fragment in its activity's layout.
	 * @param drawerLayout The DrawerLayout containing this fragment's UI.
	 */
	public void setUp(int fragmentId, DrawerLayout drawerLayout, int position) {

		mFragmentContainerView = mainAct.findViewById(fragmentId);
		mDrawerLayout = drawerLayout;

		// set a custom shadow that overlays the main content when the drawer opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

		if (mCallbacks != null) {
			mCallbacks.onNavigationDrawerItemSelected(position);
		}
	}

	private void initItems(View v) {
		LinearLayout contentLayout = (LinearLayout) v.findViewById(R.id.drawer_view);
		int count = contentLayout.getChildCount();
		for (int i = 0; i < count; i++) {
			contentLayout.getChildAt(i).setOnClickListener(this);
		}

	}

	/**
	 * {@inheritDoc}
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		System.out.println(v.getTag());
		mDrawerLayout.closeDrawers();
		mCallbacks.onNavigationDrawerItemSelected(Integer.parseInt(v.getTag().toString()));
	}
}
