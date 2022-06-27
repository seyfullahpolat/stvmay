package com.example.stvmay.feature.repo.data.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RepoResponseItem(
    val allow_forking: Boolean? = false, // true
    val archive_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/{archive_format}{/ref}
    val archived: Boolean? = false, // false
    val assignees_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/assignees{/user}
    val blobs_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/git/blobs{/sha}
    val branches_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/branches{/branch}
    val clone_url: String? = null, // https://github.com/kobeumut/activeadmin.git
    val collaborators_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/collaborators{/collaborator}
    val comments_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/comments{/number}
    val commits_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/commits{/sha}
    val compare_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/compare/{base}...{head}
    val contents_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/contents/{+path}
    val contributors_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/contributors
    val created_at: String? = null, // 2017-10-25T08:58:28Z
    val default_branch: String? = null, // master
    val deployments_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/deployments
    val description: String? = null, // The administration framework for Ruby on Rails applications.
    val disabled: Boolean? = false, // false
    val downloads_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/downloads
    val events_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/events
    val fork: Boolean? = false, // true
    val forks: Int? = 0, // 0
    val forks_count: Int? = 0, // 0
    val forks_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/forks
    val full_name: String? = null, // kobeumut/activeadmin
    val git_commits_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/git/commits{/sha}
    val git_refs_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/git/refs{/sha}
    val git_tags_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/git/tags{/sha}
    val git_url: String? = null, // git://github.com/kobeumut/activeadmin.git
    val has_downloads: Boolean? = false, // false
    val has_issues: Boolean? = false, // false
    val has_pages: Boolean? = false, // false
    val has_projects: Boolean? = false, // true
    val has_wiki: Boolean? = false, // true
    val homepage: String? = null, // https://activeadmin.info
    val hooks_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/hooks
    val html_url: String? = null, // https://github.com/kobeumut/activeadmin
    val id: Long, // 108245073
    val is_template: Boolean? = false, // false
    val issue_comment_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/issues/comments{/number}
    val issue_events_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/issues/events{/number}
    val issues_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/issues{/number}
    val keys_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/keys{/key_id}
    val labels_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/labels{/name}
    val language: String? = null, // Ruby
    val languages_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/languages
    val license: License? = null,
    val merges_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/merges
    val milestones_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/milestones{/number}
    val name: String, // activeadmin
    val node_id: String? = null, // MDEwOlJlcG9zaXRvcnkxMDgyNDUwNzM=
    val notifications_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/notifications{?since,all,participating}
    val open_issues: Int? = 0, // 0
    val open_issues_count: Int? = 0, // 0
    val owner: Owner,
    val `private`: Boolean? = false, // false
    val pulls_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/pulls{/number}
    val pushed_at: String? = null, // 2017-12-21T09:12:15Z
    val releases_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/releases{/id}
    val size: Int? = 0, // 7391
    val ssh_url: String? = null, // git@github.com:kobeumut/activeadmin.git
    val stargazers_count: Int? = 0, // 0
    val stargazers_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/stargazers
    val statuses_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/statuses/{sha}
    val subscribers_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/subscribers
    val subscription_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/subscription
    val svn_url: String? = null, // https://github.com/kobeumut/activeadmin
    val tags_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/tags
    val teams_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/teams
    val topics: List<String>? = null,
    val trees_url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin/git/trees{/sha}
    val updated_at: String? = null, // 2021-12-20T01:47:01Z
    val url: String? = null, // https://api.github.com/repos/kobeumut/activeadmin
    val visibility: String? = null, // public
    val watchers: Int? = 0, // 0
    val watchers_count: Int? = 0, // 0
    var isFavorite: Boolean = false // 0
) : Parcelable
