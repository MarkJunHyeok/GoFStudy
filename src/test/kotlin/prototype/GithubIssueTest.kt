package prototype


import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotSame

class GithubIssueTest {
    @Test
    fun `딥 카피 생성`() {
        val repository = GithubRepository("user", "name")
        val githubIssue = GithubIssue(0, "title", repository)

        val clone = githubIssue.clone()

        assertNotSame(clone, githubIssue)
        assertEquals(clone, githubIssue)
        assertEquals(clone.repository, githubIssue.repository)
        assertEquals(clone.id, githubIssue.id)
        assertEquals(clone.title, githubIssue.title)
        assertEquals(clone.repository.user, githubIssue.repository.user)
        assertEquals(clone.repository.name, githubIssue.repository.name)
    }
}