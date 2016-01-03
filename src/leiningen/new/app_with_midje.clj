(ns leiningen.new.app-with-midje
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files
                                             multi-segment]]
            [leiningen.core.main :as main]))

(def render (renderer "app-with-midje"))

(defn app-with-midje
  "FIXME: write documentation"
  [name]
  (let [sanitized (name-to-path name)
        data {:name name
              :sanitized sanitized
              :main (multi-segment sanitized)}]
    (main/info "Generating fresh 'lein new' app-with-midje project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)])))
