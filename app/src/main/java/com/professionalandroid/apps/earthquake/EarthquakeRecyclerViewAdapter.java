package com.professionalandroid.apps.earthquake;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.professionalandroid.apps.earthquake.databinding.ListItemEarthquakeBinding;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class EarthquakeRecyclerViewAdapter extends RecyclerView.Adapter<EarthquakeRecyclerViewAdapter.ViewHolder> {
    private final List<Earthquake> mEarthquakes;
    private static final SimpleDateFormat TIME_FORMATE = new SimpleDateFormat("HH:mm", Locale.US);
    private static final NumberFormat MAGNITUDE_FORMAT = new DecimalFormat("0.0");

    public EarthquakeRecyclerViewAdapter(List<Earthquake> earthquakes) {
        mEarthquakes = earthquakes;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_earthquake, parent, false);
//        return new ViewHolder(view);
        ListItemEarthquakeBinding binding = ListItemEarthquakeBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.earthquake = mEarthquakes.get(position);
//        holder.detailsView.setText(mEarthquakes.get(position).toString());
        Earthquake earthquake = mEarthquakes.get(position);
//        holder.date.setText(TIME_FORMATE.format(earthquake.getDate()));
//        holder.details.setText(earthquake.getDetails());
//        holder.magnitude.setText(MAGNITUDE_FORMAT.format(earthquake.getMagnitude()));
        holder.binding.setEarthquake(earthquake);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mEarthquakes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Earthquake earthquake;
//        public final TextView date;
//        public final TextView details;
//        public final TextView magnitude;
        public final ListItemEarthquakeBinding binding;

        public ViewHolder(ListItemEarthquakeBinding binding) {
            super(binding.getRoot());
//            date = view.findViewById(R.id.date);
//            details = view.findViewById(R.id.details);
//            magnitude = view.findViewById(R.id.magnitude);
            this.binding = binding;
            binding.setTimeformat(TIME_FORMATE);
            binding.setMagnitudeformat(MAGNITUDE_FORMAT);
        }

//        @Override
//        public String toString() {
//            return super.toString() + " ' " + detailsView.getText() + " ' ";
//        }
    }
}
