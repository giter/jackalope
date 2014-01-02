package jackalope

import (
	"fmt"
	"mgo"
	"mgo/bson"
)

func main() {


	m,err := mgo.Dial("127.0.0.1");
	
	if err != nil { 
		panic(err); 
	}
	
	defer m.Close();
	
	db := m.DB("test");
	c  := db.C("test");
	
	c.Insert(bson.M(bson.M{"A":"111"}));
	
	r := bson.M{};
	
	query := c.Find(bson.M{});
	
	iter:= query.Iter();
	
	for iter.Next(&r) {
		fmt.Println(r);
	}
	
}

