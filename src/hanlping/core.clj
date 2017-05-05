(ns hanlping.core
  (:import [com.hankcs.hanlp.seg.CRF CRFSegment]))

(def crfs-segment-path "./data/model/segment/CRFSegmentModel.txt")

;; 从官方下载data.zip,然后解压到当前项目目录下:
;; 加载"./data/model/segment/CRFSegmentModel.txt",就是加载了CRFSegmentModel.txt.bin,因为会自动加bin的后缀
(defn init-crfs-segment
  [path]
  (CRFSegment. path))

;; 只要调用一次就会保存到内存: (memoized-segment "./data/model/segment/CRFSegmentModel.txt")
(def memoized-segment (memoize init-crfs-segment))

;; (to-seg-list "你看过穆赫兰道吗" "江西鄱阳湖干枯") ;;=> (("你" "看过" "穆赫兰道" "吗") ("江西" "鄱阳湖" "干枯"))
(defn to-seg-list
  [& str-list]
  (let [segment (memoized-segment crfs-segment-path)
        _ (.enablePartOfSpeechTagging segment true)
        seg-fn (fn [st] (map #(.word %) (.seg segment st)))
        ]
    (map seg-fn str-list)
    )
  )
