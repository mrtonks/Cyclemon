package com.example.cyclemon;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MissionAdapter  extends RecyclerView.Adapter<MissionAdapter.MyViewHolder> {

    private Context mContext;
    private List<Mission> missionList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, reward;
        public ProgressBar progressBar;
        public CardView mCardView;

        public MyViewHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.missionTitle);
            reward = (TextView) view.findViewById(R.id.missionReward);
            progressBar = (ProgressBar) view.findViewById(R.id.missionProgress);

            mCardView = itemView.findViewById(R.id.card_view);
        }
    }

    public MissionAdapter(Context mContext, List<Mission> missionList){
        this.mContext = mContext;
        this.missionList = missionList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mission, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position){
        Mission mission = missionList.get(position);
        holder.title.setText(mission.getTitle());
        holder.reward.setText("Reward: " + String.valueOf(mission.getReward()) + "$");
        holder.progressBar.setMax(mission.getProgressMax());
        holder.progressBar.setProgress(mission.getProgressCur());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(view.getContext(), AchievementsActivity.class));

            }
        });
    }

    @Override
    public int getItemCount() {
        return missionList.size();
    }
}
