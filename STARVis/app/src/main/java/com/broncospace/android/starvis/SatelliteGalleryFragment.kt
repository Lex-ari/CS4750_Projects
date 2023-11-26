package com.broncospace.android.starvis

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.broncospace.android.starvis.databinding.FragmentSatelliteGalleryBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit

private const val TAG = "SatelliteGalleryFragment"
class SatelliteGalleryFragment : Fragment() {
    private var _binding: FragmentSatelliteGalleryBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentSatelliteGalleryBinding.inflate(inflater, container, false)
        binding.photoGrid.layoutManager = GridLayoutManager(context, 1)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            val response = SatelliteRepository().fetchSatellites()
            Log.d(TAG, "Response received: $response")
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}