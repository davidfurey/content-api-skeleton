package app

import scala.concurrent.ExecutionContext.Implicits.global

object App {
  def main(args: Array[String]) {
    println("Counting articles from the last 15 minutes")

    val articleCounter = new ArticleCounter
    articleCounter.count map println
  }
}
