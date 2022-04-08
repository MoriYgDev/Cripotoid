package ir.moris.cripotoid.domain.model

import ir.moris.cripotoid.data.remote.dto.TeamMember

data class CryptoDetail(
    val coinId: String,
    val name: String,
    val description: String ,
    val symbol : String,
    val rank : Int,
    val isActive : Boolean ,
    val tags : List<String>,
    val team : List<TeamMember>
)
