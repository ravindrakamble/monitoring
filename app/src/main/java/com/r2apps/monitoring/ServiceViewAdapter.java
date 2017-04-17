package com.r2apps.monitoring;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.r2apps.monitoring.databinding.ItemListBinding;

import java.util.List;

/**
 * Created by Barun.Gupta on 3/17/2017.
 */

public class ServiceViewAdapter extends RecyclerView.Adapter<ServiceViewAdapter.ViewHolder> {

    private List<ConnectedService> chatRoomList;
    private Context mContext;

    public ServiceViewAdapter(List<ConnectedService> chatroomDataset, Context context) {
        this.chatRoomList = chatroomDataset;
        mContext = context;
    }

    @Override
    public ServiceViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ServiceViewAdapter.ViewHolder holder, int position) {
        final ConnectedService connectedService = chatRoomList.get(position);

        //holder.getBinding().setVariable(BR.connectedService, chatroom);
        CardView cardView =  (CardView) holder.getBinding().getRoot();
        holder.getBinding().executePendingBindings();
        holder.bind(connectedService);
        if (Integer.parseInt(connectedService.getNoOfUpInstanceHtml()) >= Integer.parseInt(connectedService.getNoOfInstance())) {
            //green
            cardView.setCardBackgroundColor(Color.parseColor("#008000"));
        } else if(Integer.parseInt(connectedService.getNoOfUpInstanceHtml()) > 0) {
            //yellow
            cardView.setCardBackgroundColor(Color.parseColor("#FFFF00"));
            ((TextView)cardView.findViewById(R.id.subject)).setTextColor(Color.BLACK);
            ((TextView)cardView.findViewById(R.id.participants)).setTextColor(Color.BLACK);
        } else {
            cardView.setCardBackgroundColor(Color.parseColor("#FF0000"));
        }

        if(connectedService.isStartStop()){
            cardView.findViewById(R.id.rl_start_stop).setVisibility(View.VISIBLE);
        } else {
            cardView.findViewById(R.id.rl_start_stop).setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return chatRoomList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private ItemListBinding binding;

        public ViewHolder(View view) {
            super(view);
            binding = DataBindingUtil.bind(view);
            view.setOnClickListener(this);
        }

        public void bind(ConnectedService chatroom) {
            binding.setConnectedService(chatroom);
        }

        public ItemListBinding getBinding() {
            return binding;
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            ConnectedService clickedItem = chatRoomList.get(position);
            clickedItem.setStartStop(!clickedItem.isStartStop());
            notifyItemChanged(position);
        }
    }
}
