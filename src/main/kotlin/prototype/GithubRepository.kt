package prototype

import java.util.*

class GithubRepository(
    var user: String,
    var name: String,
) {
    override fun equals(other: Any?): Boolean {
        return if (this === other) {
            return true
        } else if (other === null || this.javaClass != other.javaClass) {
            return false
        } else {
            val otherRepository = other as GithubRepository
            return Objects.equals(user, otherRepository.user)
                    && Objects.equals(name, otherRepository.name)

        }
    }
}