(ns leiningen.new.app-with-midje
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "app-with-midje"))

(defn app-with-midje
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' app-with-midje project.")
    (->files data
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))
