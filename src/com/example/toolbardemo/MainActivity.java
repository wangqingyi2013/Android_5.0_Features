/*
 * Copyright © 2014 wangqingyi Ltd., All Rights Reserved.
 * For licensing terms please contact wangqingyi LTD.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.toolbardemo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.toolbardemo.Fragment.AnimDrawableFragment;
import com.example.toolbardemo.Fragment.CircularRevealFragment;
import com.example.toolbardemo.Fragment.ClippingViewFragment;
import com.example.toolbardemo.Fragment.MenuFragment;
import com.example.toolbardemo.Fragment.MenuFragment.NavigationDrawerCallbacks;
import com.example.toolbardemo.Fragment.RippleDrawableFragment;
import com.example.toolbardemo.Fragment.ToolbarItemExchangeFragment;

/**
 * The MainActivity represents
 * @version $Id$
 * @author wangqingyi
 * @datetime Nov 21, 2014 5:18:05 PM
 */
public class MainActivity extends ActionBarActivity implements NavigationDrawerCallbacks {

	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private MenuFragment menuFragment;
	Toolbar toolbar;
	private int page;

	/**
	 * {@inheritDoc}
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
		menuFragment = (MenuFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
		menuFragment.setUp(R.id.navigation_drawer, mDrawerLayout, 0);
		toolbar = (Toolbar) findViewById(R.id.demo_toolbar);
		setSupportActionBar(toolbar);

		// Set an OnMenuItemClickListener to handle menu item clicks
		// **note:if set this listener, onOptionsItemSelected will not invoke

		toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Toast.makeText(MainActivity.this, "onMenuItemClick", Toast.LENGTH_SHORT).show();
				return true;
			}
		});
		//
		// // Inflate a menu to be displayed in the toolbar
		// toolbar.inflateMenu(R.menu.main);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setShowHideAnimationEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);

		// put drawer toggle into toolbar
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
		mDrawerToggle.syncState();

		mDrawerLayout.setDrawerListener(mDrawerToggle);

	}

	//
	// private void setDrawerState(boolean isEnabled) {
	// if (isEnabled) {
	// mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
	// mDrawerToggle.onDrawerStateChanged(DrawerLayout.LOCK_MODE_UNLOCKED);
	// mDrawerToggle.syncState();
	//
	// } else {
	// mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
	// mDrawerToggle.onDrawerStateChanged(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
	// mDrawerToggle.syncState();
	// }
	// }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		icon = toolbar.getNavigationIcon();
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(this, "onOptionsItemSelected", Toast.LENGTH_SHORT).show();
		if (item.getItemId() == android.R.id.home) {
			System.out.println("home button click");
		}
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		// noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	/**
	 * {@inheritDoc}
	 * @see android.support.v7.app.ActionBarActivity#onPrepareOptionsPanel(android.view.View, android.view.Menu)
	 */
	@Override
	protected boolean onPrepareOptionsPanel(View view, Menu menu) {
		// TODO Auto-generated method stub
		return super.onPrepareOptionsPanel(view, menu);
	}

	boolean changeMenu = false;
	Drawable icon;

	/**
	 * {@inheritDoc}
	 * @see android.app.Activity#onPrepareOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.clear();
		if (changeMenu) {
			toolbar.inflateMenu(R.menu.sub);
			// getMenuInflater().inflate(R.menu.sub, menu);

			// toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_launcher));
			// toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			//
			// @Override
			// public void onClick(View v) {
			// Log.d("cek", "home selected");
			// }
			// });
			changeMenu = true;
			return true;
		} else {
			toolbar.inflateMenu(R.menu.main);
			// getMenuInflater().inflate(R.menu.main, menu);
			changeMenu = false;

		}
		return super.onPrepareOptionsMenu(menu);
	}

	public void show(View v) {
		changeMenu = !changeMenu;
		invalidateOptionsMenu();
		// toolbar.setNavigationIcon(icon);
		// toolbar.setNavigationOnClickListener(null);
		// mDrawerToggle.syncState();
		// setDrawerState(changeMenu);
		// startActivity(new Intent(this, ConversationActivity.class));
	}

	@Override
	public void onBackPressed() {
		if (mDrawerLayout.isDrawerOpen(Gravity.START | Gravity.LEFT)) { // <----
																		// added
			mDrawerLayout.closeDrawers();
			return;
		}
		super.onBackPressed();
	}

	/**
	 * {@inheritDoc}
	 * @see com.example.toolbardemo.Fragment.MenuFragment.NavigationDrawerCallbacks#onNavigationDrawerItemSelected(int)
	 */
	@Override
	public void onNavigationDrawerItemSelected(int position) {
		page = position;
		showFragment(position);
	}

	private void showFragment(int position) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction ft = fragmentManager.beginTransaction();
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		Fragment f;
		switch (position) {
			case 0:
				f = fragmentManager.findFragmentByTag("TodayScheduleFragment");
				if (f == null) {
					f = new ToolbarItemExchangeFragment();
				}
				ft.replace(R.id.content_frame, f, "TodayScheduleFragment").commit();
				break;
			case 1:
				f = fragmentManager.findFragmentByTag("ScheduleReportFragment");
				if (f == null) {
					f = new RippleDrawableFragment();
				}
				ft.replace(R.id.content_frame, f, "ScheduleReportFragment").commit();
				break;
			case 2:
				f = fragmentManager.findFragmentByTag("SettingFragment");
				if (f == null) {
					f = new AnimDrawableFragment();
				}
				ft.replace(R.id.content_frame, f, "SettingFragment").commit();
				break;
			case 3:
				f = fragmentManager.findFragmentByTag("ClippingView");
				if (f == null) {
					f = new ClippingViewFragment();
				}
				ft.replace(R.id.content_frame, f, "ClippingView").commit();
				break;
			case 4:
				f = fragmentManager.findFragmentByTag("CircularReveal");
				if (f == null) {
					f = new CircularRevealFragment();
				}
				ft.replace(R.id.content_frame, f, "CircularReveal").commit();
				break;
			default:

				break;
		}
	}
}
