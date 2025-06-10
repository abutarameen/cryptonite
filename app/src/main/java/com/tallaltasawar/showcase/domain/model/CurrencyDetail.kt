package com.tallaltasawar.showcase.domain.model

import com.tallaltasawar.showcase.data.dto.Links
import com.tallaltasawar.showcase.data.dto.TeamMember
import com.tallaltasawar.showcase.data.dto.Whitepaper

data class CurrencyDetail(
    val description: String,
    val id: String,
    val links: Links,
    val logo: String,
    val message: String?,
    val name: String,
    val open_source: Boolean,
    val org_structure: String,
    val proof_type: String,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<TeamMember>,
    val whitepaper: Whitepaper
)
