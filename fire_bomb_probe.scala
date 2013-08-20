import scala.util.Random

val random = new Random
case class Position(x: Int, y: Int)


 def random2DimArray(dim1: Int, dim2: Int) = 
 Array.fill(dim1, dim2){random.nextInt(2)}
 
 val data = random2DimArray(12, 15)

 var players = collection.mutable.Map.empty[String, Position]

 def swap = players.map(_.swap)
 /*("p1" -> (1,0),
 	"p2"->(1,1), "p3"->(1,3), "p4"->(1,4), "p5"->(1,5),
 	"p2.2"->(2,1), "p3.2"->(2,3), "p4.2"->(2,4), "p5.2"->(2,5),
 	"p2.3"->(3,1), "p3.3"->(3,3), "p4.3"->(3,4), "p5.3"->(3,5),
 	"p2.4"->(4,1), "p3.4"->(4,3), "p4.4"->(4,4), "p5.4"->(4,5),
 	"p2.5"->(5,1), "p3.5"->(5,3), "p4.5"->(5,4), "p5.5"->(5,5))
*/

def posList(pos: Position) = List[Position](pos)

var pl = players.values.toList

def randomPosition :Position = {
    val pos = new Position(random.nextInt(11), random.nextInt(14))
   if(data(pos.x)(pos.y).equals(1)) {
   	if (pl.contains(posList(pos))) randomPosition else pos
  } else randomPosition
}

def addPlayer(user: String) = players += (user -> randomPosition)


def check (list: List[Position]) = {
	if(!list.isEmpty){
		val buffer = new collection.mutable.ListBuffer[String]()
		for(lis <- list if pl.contains(lis)) {
			buffer += swap(lis)
		}
		val li = buffer.toList
		println(li)
	}
}


def bomb(pos: Position) = { 
	val buffer = new collection.mutable.ListBuffer[Position]
	for (i <- pos.x - 2 to pos.x + 2){
			buffer += Position(i , pos.y)

			//println(listX)
			//if(pl.contains(listX.head)) println("bingo x " + swap(listX.head))
		}
	for (i <- pos.y - 2 to pos.y + 2){
			buffer += Position(pos.x , i)
			//if(pl.contains(listY.head)) println("bingo y " + swap(listY.head))	
		}
		val list = buffer.distinct.toList
		println(list)
		check(list)
}
	
def users = for(i <- 0 until 15) addPlayer("p" + i.toString)

users

def li = pl
def liDi = li.distinct
bomb(Position(9,4))
check(List(Position(9,4)))
addPlayer("u")
println(players)
println(li)
println(liDi)
swap(Position(8,10))

	