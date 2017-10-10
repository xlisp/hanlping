(ns hanlping.hmm
  (:import
   (java.util.List)
   (com.hankcs.hanlp.seg Segment)
   (com.hankcs.hanlp.seg.common Term)
   (com.hankcs.hanlp HanLP)
   (com.hankcs.hanlp.seg.HMM HMMSegment)))

(def hmm-segment-path "./data/model/segment/HMMSegmentModel.txt")

(defn init-hmm-segment
  [^String path]
  (HMMSegment. path))

(def memoized-hmm-segment (memoize init-hmm-segment))

(def segment (memoized-hmm-segment hmm-segment-path))
