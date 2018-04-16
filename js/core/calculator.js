var cache = new Map();

function calculate(personA, personB) {
  // lookup from the cache.
  var key = (personA + "+" + personB).toLowerCase();
  var result = cache.get(key);
  // lets reverse the order and try again!
  if (!result) {
    var key2 = (personB + "+" + personA).toLowerCase();
    result = cache.get(key2);
  }
  // create new entry with default oder.
  if (!result) {
    result = random(1, 100);
    cache.set(key, result);
  }
  return result;
}

function random(from, to) {
  return Math.floor(Math.random() * to) + from;
}
