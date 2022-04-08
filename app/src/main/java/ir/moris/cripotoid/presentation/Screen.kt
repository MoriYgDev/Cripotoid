package ir.moris.cripotoid.presentation

sealed class Screen(val rout : String){
    object CryptoListScreen : Screen("coin_list_screen")
    object CryptoDetailScreen : Screen("coin_detail_screen")
}
