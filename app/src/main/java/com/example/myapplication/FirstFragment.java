package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentFirstBinding;
import com.google.android.material.snackbar.Snackbar;

import jp.co.rakuten.reward.rewardsdk.api.RakutenReward;
import jp.co.rakuten.reward.rewardsdk.api.ui.RewardButton;
import jp.co.rakuten.reward.rewardsdk.api.status.RewardButtonColorType;
import jp.co.rakuten.reward.rewardsdk.api.status.BadgePosition;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
// Get instance of portal button
        RewardButton portalButton = (RewardButton)view.findViewById(R.id.portalButton);


// Change color type of button
        portalButton.setButtonColor(RewardButtonColorType.DARK);

//// Change image of button
//        portalButton.setImage(R.drawable.custom_image);

// Change badge position of button
        portalButton.setBadgePosition(BadgePosition.POSITION_CENTER);
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);

                RakutenReward.getInstance().openPortal();
//                RakutenReward.getInstance().getStatus();
//                Context context = getActivity().getApplicationContext();
//                boolean success = RakutenReward.getInstance().openAdPortal(context, 1);
//                Snackbar.make(view, "Replace with your own action"+context, Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
        binding.buttonFirst2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);

                RakutenReward.getInstance().openPortal();
//                RakutenReward.getInstance().getStatus();
//                Context context = getActivity().getApplicationContext();
//                boolean success = RakutenReward.getInstance().openAdPortal(context, 1);
//                Snackbar.make(view, "Replace with your own action"+context, Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
        binding.buttonFirst3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);

                RakutenReward.getInstance().openPortal();
//                RakutenReward.getInstance().getStatus();
//                Context context = getActivity().getApplicationContext();
//                boolean success = RakutenReward.getInstance().openAdPortal(context, 1);
//                Snackbar.make(view, "Replace with your own action"+context, Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}