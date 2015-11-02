package app.contentutils

import com.gu.contentapi.client.GuardianContentClient
import com.gu.contentapi.client.model.SearchQuery
import org.joda.time.DateTime

import scala.concurrent.ExecutionContext.Implicits.global

class ArticleCounter {
  val contentApiClient = new GuardianContentClient("api-key-here")

  def count = {
    val until = DateTime.now
    val from = until.minusMinutes(15)
    val q = new SearchQuery().fromDate(from).toDate(until)
    val itemQuery = q.withParameter(q.showBlocks.withValue(Some("all")))
      .withParameter(q.showElements.withValue(Some("all")))
      .withParameter(q.showFields.withValue(Some("all")))
      .withParameter(q.showTags.withValue(Some("all")))
      .withParameter(q.page.withValue(Some(1)))
      .withParameter(q.pageSize.withValue(Some(100)))
      .orderBy("oldest")

    contentApiClient.getResponse(itemQuery) map { response =>
      response.results.size
    }
  }
}
