package ru.gdgkazan.popularmoviesclean.screen.details;

import android.support.annotation.NonNull;
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
import ru.gdgkazan.popularmoviesclean.domain.model.Movie;
import ru.gdgkazan.popularmoviesclean.domain.model.Video;


public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideoHolder> {

    private List<Video> data = new ArrayList<>();
    private OnItemClickListener mListener;

    public VideosAdapter(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    private final View.OnClickListener mInternalListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Video video = (Video) view.getTag();
            mListener.onItemClick(view, video);
        }
    };

    @Override
    public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_videos, parent, false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoHolder holder, int position) {
        Video video = data.get(position);
        holder.tvName.setText(video.getName());
        holder.itemView.setTag(video);
        holder.itemView.setOnClickListener(mInternalListener);
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

    public interface OnItemClickListener {

        void onItemClick(@NonNull View view, @NonNull Video video);

    }
}

