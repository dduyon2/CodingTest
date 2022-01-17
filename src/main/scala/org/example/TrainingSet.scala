package org.example

object TrainingSet {

  def solution(n: Int, lost: Vector[Int], reserve: Vector[Int]): Int = {
    var l = lost.sorted
    var r = reserve.sorted

    //여벌 체육복을 가져온 학생이 체육복을 도난당했을 경우
    r.foreach { i =>
      l.find(_ == i).map{s =>
        l = l.filter(x => x != s)
        r = r.filter(_ != i) }
    }

    r.foreach { i =>
      val found = l.find(_ == i - 1).getOrElse(l.find(_ == i + 1).getOrElse(-1))
      l = l.filter(x => x != found)
    }

    n-l.size  }

}
