package ru.gdgkazan.popularmoviesclean.screen.details;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.gdgkazan.popularmoviesclean.R;
import ru.gdgkazan.popularmoviesclean.domain.model.Video;


public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideoHolder> {

    private List<Video> data = new ArrayList<>();

    @Override
    public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_videos, parent, false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoHolder holder, int position) {
        Video video = data.get(position);
        holder.tvName.setText(video.getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Video> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    class VideoHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvName)
        TextView tvName;

        public VideoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

