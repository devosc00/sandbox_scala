val array = Array(1,2,3,4,5)

  val second = array.tail.head

val someMap = Map((0,0) -> 1, (0,1) -> 0, (0,2) -> 1, (0,3) -> 1, (0,4)->0,
	(1,0) -> 1,(1,1) -> 1, (1,2) -> 1, (1,3) -> 1, (1,4) -> 0)

val playersMap = Map("p1" -> (0,0), "p2" -> (0,1))


	  def addPlayer (move: String) = {
  		val stay = playersMap.getOrElse(move)
  	if(someMap(stay) = 1){playersMap.updated(stay)}
  }

mapPlus ++ List("iii"-> 4, "ia" -> 5)

mapPlus - "vi"

val ar =++ array :+ (6)
ar.drop(1)
ar
