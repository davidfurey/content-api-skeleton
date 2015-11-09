package app.contentutils

import com.gu.contentapi.client.GuardianContentClient
import com.gu.contentapi.client.model.SearchQuery
import org.joda.time.DateTime

import scala.concurrent.ExecutionContext.Implicits.global

class ArticleCounter {
  val contentApiClient = new GuardianContentClient("kpfvwzq9xm3vfu22grbh9yqe")

  def count = {
    val until = DateTime.now
    val from = until.minusMinutes(15)
    val searchQuery = new SearchQuery()
      .fromDate(from)
      .toDate(until)
      .showBlocks("all")
      .showElements("all")
      .showFields("all")
      .showTags("all")
      .page(1)
      .pageSize(100)
      .orderBy("oldest")

    contentApiClient.getResponse(searchQuery) map { response =>
      response.results.size
    }
  }
}
