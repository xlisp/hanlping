(ns hanlping.core
  (:import
   [java.util.List]
   [com.hankcs.hanlp.seg Segment]
   [com.hankcs.hanlp.seg.CRF CRFSegment]
   [com.hankcs.hanlp.seg.common Term]))

(set! *warn-on-reflection* true)

(def crfs-segment-path "./data/model/segment/CRFSegmentModel.txt")

;; 从官方下载data.zip,然后解压到当前项目目录下:
;; 加载"./data/model/segment/CRFSegmentModel.txt",就是加载了CRFSegmentModel.txt.bin,因为会自动加bin的后缀
(defn init-crfs-segment
  [^String path]
  (CRFSegment. path))

;; 只要调用一次就会保存到内存: (memoized-segment "./data/model/segment/CRFSegmentModel.txt")
(def memoized-segment (memoize init-crfs-segment))

;; (to-seg-list "你看过穆赫兰道吗" "江西鄱阳湖干枯") ;;=> [[[r 你] [v 看过] [nz 穆赫兰道] [y 吗]] [[ns 江西] [ns 鄱阳湖] [a 干枯]]]
;; n* 就是名称,按需要过滤出来
(defn to-seg-list
  [& str-list]
  (let [^Segment segment (memoized-segment crfs-segment-path)
        _ (.enablePartOfSpeechTagging segment true)
        seg-fn (fn [^String st]
                 (mapv
                  (juxt #(.toString (.nature ^Term %)) #(.word ^Term %))
                  (.seg
                   segment
                   st)
                  ))
        ]
    (mapv seg-fn str-list)
    )
  )

;; Run 一些测试的例子
(defn -main
  [& args]
  (println (to-seg-list "你看过穆赫兰道吗" "江西鄱阳湖干枯的"))
  )
