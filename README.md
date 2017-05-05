# hanlping

A Clojure library for [HanLP](https://github.com/hankcs/HanLP)

## Usage: Leiningen/Boot

` [hanlping "0.1.0-SNAPSHOT"] `

```clojure

user=> (ns test (:require [hanlping.core :as han]))
nil

test=> han/crfs-segment-path
"./data/model/segment/CRFSegmentModel.txt"

test=> (time (han/to-seg-list "你看过穆赫兰道吗" "江西鄱阳湖干枯"))

"Elapsed time: 2256.311219 msecs"
(("你" "看过" "穆赫兰道" "吗") ("江西" "鄱阳湖" "干枯"))

```

## License

Copyright © 2017 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
