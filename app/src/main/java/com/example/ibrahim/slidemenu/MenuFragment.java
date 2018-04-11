package com.example.ibrahim.slidemenu;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ibrahim.slidemenu.fragments.HomeFragment;
import com.example.ibrahim.slidemenu.fragments.SecondFragment;

import java.util.ArrayList;


/**
 * Created by Ahmed on 5/31/2017.
 */

public class MenuFragment extends Fragment {

    private View view;
    public ListView listView;
    SlidingMenuAdapter adapter;
    private ArrayList<SideMenuItemModel> listMenuItems;
    private String[] menuItemTitle;
    private int[] menuItemIcon;

    public static android.support.v4.app.Fragment newInstance() {
        MenuFragment fragment = new MenuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        menuItemTitle = new String[]{"Home","Home","Home","Home","Home","Home"};

        menuItemIcon = new int[]{R.drawable.ic_home_marker,R.drawable.ic_home_marker,R.drawable.ic_home_marker,R.drawable.ic_home_marker,R.drawable.ic_home_marker,R.drawable.ic_home_marker};


//        adapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,menuItemTitle);
        //create menu items
        listMenuItems = new ArrayList<>();
        listMenuItems.add(new SideMenuItemModel(menuItemIcon[0], menuItemTitle[0]));
        listMenuItems.add(new SideMenuItemModel(menuItemIcon[1], menuItemTitle[1]));
        listMenuItems.add(new SideMenuItemModel(menuItemIcon[2], menuItemTitle[2]));
        listMenuItems.add(new SideMenuItemModel(menuItemIcon[3], menuItemTitle[3]));
        listMenuItems.add(new SideMenuItemModel(menuItemIcon[4], menuItemTitle[4]));
        listMenuItems.add(new SideMenuItemModel(menuItemIcon[5], menuItemTitle[5]));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.frag_side_menu, container, false);
        listView = (ListView) view.findViewById(R.id.list);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListViewAdapter();
    }


    private void setListViewAdapter() {
        adapter = new SlidingMenuAdapter(getActivity(), R.layout.item_menu, listMenuItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onItemClickListener());
    }


    private class SlidingMenuAdapter extends ArrayAdapter<SideMenuItemModel> {

        private FragmentActivity activity;
        private ArrayList<SideMenuItemModel> items;

        public SlidingMenuAdapter(FragmentActivity activity, int resource, ArrayList<SideMenuItemModel> objects) {
            super(activity, resource, objects);
            this.activity = activity;
            this.items = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            try {
                ViewHolder holder = null;
                LayoutInflater inflater = (LayoutInflater) activity
                        .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

                // If holder not exist then locate all view from UI file.
                if (convertView == null) {
                    // inflate UI from XML file
                    convertView = inflater.inflate(R.layout.item_menu_sliding, parent, false);
                    // get all UI view
                    holder = new ViewHolder(convertView);
                    // set tag for holder
                    convertView.setTag(holder);

                } else {

                    holder = (ViewHolder) convertView.getTag();

                }
                holder.itemName.setText(getItem(position).getMenuItemName());
                holder.itemImage.setImageResource(getItem(position).getImageResource());


            } catch (Exception e) {
                System.out.println("Error in MenuFrag : " + e.getMessage());
            }
            return convertView;
        }

        private class ViewHolder {

            private ImageView itemImage;
            public TextView itemName;

            public ViewHolder(View v) {
                itemName = (TextView) v.findViewById(R.id.name);
                itemImage = (ImageView) v.findViewById(R.id.image);
            }
        }
    }


    private AdapterView.OnItemClickListener onItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        changeFragment(new HomeFragment());
                        break;
                    case 1:
                        changeFragment(new SecondFragment());
                        break;
                    case 2:
                        changeFragment(new HomeFragment());
                        break;
                    case 3:
                        changeFragment(new SecondFragment());
                        break;
                    case 4:
                        changeFragment(new HomeFragment());
                        break;
                    case 5:
                        changeFragment(new SecondFragment());
                        break;
                }

            }

        };
    }

    private void changeFragment(Fragment targetFragment) {
        Fragment fragment = targetFragment;
        ((MainActivity) getActivity()).transactionFragments(fragment,
                R.id.main_container);

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, fragment, "fragment")
                .addToBackStack(fragment.toString())
                .setTransitionStyle(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();

    }

}
