class Song {
  constructor(typeList, name, time) {
    this.typeList = typeList;
    this.name = name;
    this.time = time;
  }
}

function solve(input) {
  let typeToDisplay = input.pop();
  let songsCnt = input.shift();
  
  for (const line of input) {
    let tokens = line.split(",");
    let songArr = tokens[0].split("_");
    let typeList = songArr[0];
    let name = songArr[1];
    let time = songArr[2];
    let song = new Song(typeList, name, time)

    if (typeToDisplay === "all" || typeList === typeToDisplay) {
      console.log(song.name);
    
    }
  }
}

solve([
  3,
  "favourite_DownTown_3:14",
  "favourite_Kiss_4:16",
  "favourite_Smooth Criminal_4:01",
  "favourite",
]);
solve([
  4,
  "favourite_DownTown_3:14",
  "listenLater_Andalouse_3:24",
  "favourite_In To The Night_3:58",
  "favourite_Live It Up_3:48",
  "listenLater",
]);
solve([2, "like_Replay_3:15", "ban_Photoshop_3:48", "all"]);
