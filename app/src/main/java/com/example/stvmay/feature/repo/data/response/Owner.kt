package com.example.stvmay.feature.repo.data.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(
    val avatar_url: String, // https://avatars.githubusercontent.com/u/5182289?v=4
    val events_url: String? = null, // https://api.github.com/users/kobeumut/events{/privacy}
    val followers_url: String? = null, // https://api.github.com/users/kobeumut/followers
    val following_url: String? = null, // https://api.github.com/users/kobeumut/following{/other_user}
    val gists_url: String? = null, // https://api.github.com/users/kobeumut/gists{/gist_id}
    val gravatar_id: String? = null,
    val html_url: String? = null, // https://github.com/kobeumut
    val id: Long? = 0, // 5182289
    val login: String, // kobeumut
    val node_id: String? = null, // MDQ6VXNlcjUxODIyODk=
    val organizations_url: String? = null, // https://api.github.com/users/kobeumut/orgs
    val received_events_url: String? = null, // https://api.github.com/users/kobeumut/received_events
    val repos_url: String? = null, // https://api.github.com/users/kobeumut/repos
    val site_admin: Boolean? = false, // false
    val starred_url: String? = null, // https://api.github.com/users/kobeumut/starred{/owner}{/repo}
    val subscriptions_url: String? = null, // https://api.github.com/users/kobeumut/subscriptions
    val type: String? = null, // User
    val url: String? = null // https://api.github.com/users/kobeumut
) : Parcelable
