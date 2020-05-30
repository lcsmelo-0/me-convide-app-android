package com.example.meconvideapp.viewHolder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meconvideapp.R;
import com.example.meconvideapp.entities.GuestEntity;
import com.example.meconvideapp.listener.OnGuestListenerInteractionListener;

public class GuestViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextName;
    private Context context;
    private ImageView mImageRemove;

    public GuestViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.mTextName = (TextView) itemView.findViewById(R.id.text_name);
        this.mImageRemove = itemView.findViewById(R.id.image_remove);
        this.context = context;
    }

    public void bindData(final GuestEntity guestEntity, final OnGuestListenerInteractionListener listener) {
        this.mTextName.setText(guestEntity.getName());
        this.mTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onListClick(guestEntity.getId());
            }
        });

        this.mImageRemove.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle(R.string.remocao_convidado)
                        .setMessage(R.string.deseja_remover)
                        .setIcon(R.drawable.ic_menu_camera)
                        .setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listener.onDeleteClick(guestEntity.getId());

                            }
                        })
                        .setNeutralButton(R.string.nao, null)
                        .show();
            }
        });

        this.mTextName.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle(R.string.remocao_convidado)
                        .setMessage(R.string.deseja_remover)
                        .setIcon(R.drawable.ic_menu_camera)
                        .setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listener.onDeleteClick(guestEntity.getId());

                            }
                        })
                        .setNeutralButton(R.string.nao, null)
                        .show();

                return true;
            }
        });
    }
}
