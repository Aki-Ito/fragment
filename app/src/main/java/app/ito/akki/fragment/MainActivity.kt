package app.ito.akki.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//最初にHogeFragmentが表示。HogeFragment内のボタンが押されるとFugaFragmentに切り替わる。
class MainActivity : AppCompatActivity(), HogeFragment.OnHogeFragmentListener, FugaFragment.OnFugaFragmentListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //FragmentTransactionのインスタンスを取得する
        val hogeFragment = HogeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        //addして追加する。一つ目の引数には親であるViewGroup、二つ目の引数には追加するフラグメント
        transaction.add(R.id.container, hogeFragment)
        //コミットしないと変更が適用されない。
        transaction.commit()
    }

    override fun onHogeFragmentAddFragment(){
        val fugaFragment = FugaFragment.newInstance("りんご", "バナナ")
        val transaction = supportFragmentManager.beginTransaction()
        //idで識別されるコンテナに現在あるフラグメントをfugaFragmentに置き換える。
        transaction.replace(R.id.container, fugaFragment)
        //バックスタックにトランザクションを追加する。戻るボタンを選択すると前のフラグメントに戻れるようにする。
        transaction.addToBackStack(null)
        transaction.commit()
    }


    override fun onFugaFragmentFinish(){
        //バックスタックから一つ前のフラグメントを取り出す。
        supportFragmentManager.popBackStack()
    }
}