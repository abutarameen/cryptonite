package com.tallaltasawar.showcase.data.dto

import com.tallaltasawar.showcase.domain.model.CurrencyDetail

data class CurrencyDetailDto(
    val description: String,
    val development_status: String,
    val first_data_at: String,
    val hardware_wallet: Boolean,
    val hash_algorithm: String,
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val last_data_at: String,
    val links: Links,
    val links_extended: List<LinksExtended>,
    val logo: String,
    val message: String,
    val name: String,
    val open_source: Boolean,
    val org_structure: String,
    val proof_type: String,
    val rank: Int,
    val started_at: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val type: String,
    val whitepaper: Whitepaper
)

fun CurrencyDetailDto.toCurrencyDetail() = CurrencyDetail(
    rank = rank,
    symbol = symbol,
    name = name,
    description = description,
    id = id,
    links = links,
    logo = logo,
    message = message,
    open_source = open_source,
    team = team,
    tags = tags.map { it.name },
    whitepaper = whitepaper,
    proof_type = proof_type,
    org_structure = org_structure
)