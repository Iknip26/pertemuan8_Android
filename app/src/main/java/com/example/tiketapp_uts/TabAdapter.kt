package com.example.tiketapp_uts
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(act: ticket) : FragmentStateAdapter(act) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> activeTicket()
            1 -> waitingTicket()
            else -> throw IllegalArgumentException("Position out of array")
        }
    }
}