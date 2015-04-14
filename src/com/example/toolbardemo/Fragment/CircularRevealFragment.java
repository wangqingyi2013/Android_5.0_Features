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

import android.animation.Animator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;

import com.example.toolbardemo.R;

/**
 * The CircularRevealFragment represents
 * @version $Id$
 * @author wangqingyi
 * @datetime Apr 14, 2015 5:13:30 PM
 */
public class CircularRevealFragment extends Fragment implements OnClickListener {

	private TextView tv1, tv2, tv3, tv4;

	/**
	 * {@inheritDoc}
	 * @see android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		tv1 = (TextView) getActivity().findViewById(R.id.textView1);
		tv2 = (TextView) getActivity().findViewById(R.id.textView2);
		tv3 = (TextView) getActivity().findViewById(R.id.textView3);
		tv4 = (TextView) getActivity().findViewById(R.id.textView4);
		tv1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Animator animator = ViewAnimationUtils.createCircularReveal(tv1, tv1.getWidth() / 2, tv1.getHeight() / 2, tv1.getWidth(), 0);
				animator.setInterpolator(new AccelerateDecelerateInterpolator());
				animator.setDuration(1000);
				animator.start();
			}
		});
		tv2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Animator animator = ViewAnimationUtils.createCircularReveal(tv2, 0, 0, 0, (float) Math.hypot(tv2.getWidth(), tv2.getHeight()));
				animator.setInterpolator(new AccelerateInterpolator());
				animator.setDuration(1000);
				animator.start();
			}
		});
		tv3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Animator animator = ViewAnimationUtils.createCircularReveal(tv3, tv3.getWidth() / 2, tv3.getHeight() / 2, 0, tv3.getWidth());
				animator.setInterpolator(new AccelerateInterpolator());
				animator.setDuration(1000);
				animator.start();
			}
		});
		tv4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Animator animator = ViewAnimationUtils.createCircularReveal(tv4, 0, 0, (float) Math.hypot(tv4.getWidth(), tv4.getHeight()), 0);
				animator.setInterpolator(new AccelerateInterpolator());
				animator.setDuration(1000);
				animator.start();
			}
		});
	}

	/**
	 * {@inheritDoc}
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_circular_reveal, container, false);
	}

	/**
	 * {@inheritDoc}
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
