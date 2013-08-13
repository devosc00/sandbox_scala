 import scala.util.Random

val random = new Random
case class Position(x: Int, y: Int)


 def random2DimArray(dim1: Int, dim2: Int) = 
 Array.fill(dim1, dim2){random.nextInt(2)}
 
 val data = random2DimArray(12, 15)

 var players = collection.mutable.Map.empty[String, Position]
 val pl = players.values.toList
 /*("p1" -> (1,0),
 	"p2"->(1,1), "p3"->(1,3), "p4"->(1,4), "p5"->(1,5),
 	"p2.2"->(2,1), "p3.2"->(2,3), "p4.2"->(2,4), "p5.2"->(2,5),
 	"p2.3"->(3,1), "p3.3"->(3,3), "p4.3"->(3,4), "p5.3"->(3,5),
 	"p2.4"->(4,1), "p3.4"->(4,3), "p4.4"->(4,4), "p5.4"->(4,5),
 	"p2.5"->(5,1), "p3.5"->(5,3), "p4.5"->(5,4), "p5.5"->(5,5))
*/

def posList(pos: Position) = List[Position](pos)

 def randomPosition :Position = {
   val pos = new Position(random.nextInt(11), random.nextInt(14))
   if(data(pos.x)(pos.y).equals(1) 
   	&&(!pl.contains(posList(pos)))) pos else randomPosition   	
  }

	def addPlayer(user: String) = players += (user -> randomPosition)

/*		def bomb(pos: Position) = {(list: List[Position])
		   match {
		  	case (pos.x > 1, pos.y > 1) => for{
		  							i<-pos.x - 2 to pos.x + 2
		  							j<-pos.y -2 to pos.y + 2
		  							} yield list :+ list(pos)
		  }
		  
		}*/

val users = for(i <- 0 until 10) addPlayer("p" + i.toString)
val li = pl
val liDi = li.distinct
println(li)
println(liDi)

	