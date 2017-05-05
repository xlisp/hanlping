(ns hanlping.core
  (:import [com.hankcs.hanlp.seg.CRF CRFSegment]))

;; 从官方下载data.zip,然后解压到当前项目目录下:
;; 加载"./data/model/segment/CRFSegmentModel.txt",就是加载了CRFSegmentModel.txt.bin,因为会自动加bin的后缀
(defn init-crfs-segment
  [path]
  (CRFSegment. path))

;; (memoized-segment "./data/model/segment/CRFSegmentModel.txt")
(def memoized-segment (memoize init-crfs-segment))

