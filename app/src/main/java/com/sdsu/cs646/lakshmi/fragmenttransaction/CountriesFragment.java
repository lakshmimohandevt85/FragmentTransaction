package com.sdsu.cs646.lakshmi.fragmenttransaction;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;


public class CountriesFragment extends ListFragment implements AdapterView.OnItemClickListener
{

    private OnEditFinishedListener editListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_countries, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.country_names, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
        editListener = (OnEditFinishedListener) getActivity();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

        String country = "";
        if (position == 0)
        {
            country = getResources().getString(R.string.country_india);
        }
        else if (position == 1)
        {
            country = getResources().getString(R.string.country_usa);
        }
        else if (position == 2){
            country = getResources().getString(R.string.country_mexico);
        }

        Toast.makeText(getActivity(), country, Toast.LENGTH_SHORT).show();
        editListener.onEditFinished(country);

    }

}
