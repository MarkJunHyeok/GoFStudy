package prototype

import java.util.*

class GithubIssue(
    var id: Int,
    var title: String,
    var repository: GithubRepository
) : Cloneable {

    public override fun clone(): GithubIssue {
        val githubRepository = GithubRepository(this.repository.user, this.repository.name)
        return GithubIssue(id, title, githubRepository)
    }

    override fun equals(other: Any?): Boolean {
        return if (this === other) {
            return true
        } else if (other === null || this.javaClass != other.javaClass) {
            return false
        } else {
            val githubIssue = other as GithubIssue
            return id == githubIssue.id
                    && Objects.equals(title, githubIssue.title)
                    && Objects.equals(repository, githubIssue.repository)
        }
    }
}