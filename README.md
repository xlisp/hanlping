# hanlping

A Clojure library for [HanLP](https://github.com/hankcs/HanLP)

## Usage: Leiningen/Boot

` [hanlping "0.1.1-SNAPSHOT"] `

* to-seg-list, 返回分词的词性和分词 `[type word]`, n*为名词, [详情请看具体词性标注](http://www.hankcs.com/nlp/part-of-speech-tagging.html#h2-8)

```clojure

user=> (ns test (:require [hanlping.core :as han]))
nil

test=> han/crfs-segment-path
"./data/model/segment/CRFSegmentModel.txt"

test=> (time (han/to-seg-list "你看过穆赫兰道吗" "江西鄱阳湖干枯"))
"Elapsed time: 2256.311219 msecs"
[[[r 你] [v 看过] [nz 穆赫兰道] [y 吗]] [[ns 江西] [ns 鄱阳湖] [a 干枯]]]

;;=> not first call: 
"Elapsed time: 0.08001 msecs"
"Elapsed time: 0.079739 msecs"
...

```

## License

Copyright © 2017 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
