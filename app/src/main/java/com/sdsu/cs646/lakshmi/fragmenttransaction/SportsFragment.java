package com.sdsu.cs646.lakshmi.fragmenttransaction;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;


public class SportsFragment extends ListFragment implements AdapterView.OnItemClickListener
{

    private OnEditFinishedListener editListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        return inflater.inflate(R.layout.fragment_sports, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        getListView().setOnItemClickListener(this);
        editListener = (OnEditFinishedListener) getActivity();
    }

    /**
     * This method will load the sport list based on the country selected.
     * @param country
     */
    public void getSportsData(String country)
    {

        ArrayAdapter adapter = null;

        if (country.equals(getResources().getString(R.string.country_india)))
        {
            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.India, android.R.layout.simple_list_item_1);
        }
        else if (country.equals(getResources().getString(R.string.country_usa)))
        {
            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.USA, android.R.layout.simple_list_item_1);
        }

        else if (country.equals(getResources().getString(R.string.country_mexico)))
        {
            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Mexico, android.R.layout.simple_list_item_1);
        }

        setListAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

        Toast.makeText(getActivity(), parent.getItemAtPosition(position) + " Selected", Toast.LENGTH_SHORT).show();
        editListener.onEditFinished(""+parent.getItemAtPosition(position));
    }

}