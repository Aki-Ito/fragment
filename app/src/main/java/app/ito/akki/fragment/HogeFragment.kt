package app.ito.akki.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import java.lang.RuntimeException

class HogeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var listener: OnHogeFragmentListener? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,//フラグメントのレイアウトが挿入される親(ViewGroup)
        savedInstanceState: Bundle?
    ): View? {
        //レイアウトを読み込んでいる。
        val fragmentView = inflater.inflate(R.layout.fragment_hoge, container, false)
        val addFragment = fragmentView.findViewById<Button>(R.id.addFragment)

        addFragment.setOnClickListener {
            addFragment()
        }
        return fragmentView
    }

    fun addFragment(){
        listener?.onHogeFragmentAddFragment()
    }

    //フラグメントをアクティビティに追加するときにシステムが呼び出すメソッド
    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is OnHogeFragmentListener){
            listener = context
        }else{
            throw RuntimeException("$context must implement OnHogeFragmentListener")
        }
    }

    //アクティビティとフラグメントの関連付けが解除された時に呼ばれる。
    override fun onDetach() {
        super.onDetach()

        listener = null
    }

    interface OnHogeFragmentListener{
        fun onHogeFragmentAddFragment()
    }


}