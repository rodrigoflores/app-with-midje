(ns leiningen.new.app-with-midje
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files
                                             multi-segment sanitize-ns]]
            [java-time :as jt]
            [leiningen.core.main :as main]))

(def render (renderer "app-with-midje"))

(def lib-versions {:schema "1.1.6"
                   :midje  "1.8.3"})

(defn app-with-midje [name]
  (let [sanitized (name-to-path name)
        main (multi-segment sanitized "core")
        nested-dirs (name-to-path main)
        main-ns (sanitize-ns nested-dirs)
        repl-ns (multi-segment (sanitize-ns sanitized) "repl")
        repl-file (name-to-path repl-ns)
        data {:name name
              :sanitized sanitized
              :sanitized-ns (sanitize-ns sanitized)
              :main-ns main-ns
              :nested-dirs nested-dirs
              :repl-ns repl-ns
              :repl-file repl-file
              :main main
              :midje-version (:midje lib-versions)
              :schema-version (:schema lib-versions)
              :year (-> (jt/local-date)
                        jt/year
                        (.getValue))}]
    (main/info "Generating fresh 'lein new' app-with-midje project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             [".gitignore" (render "gitignore" data)]
             ["README" (render "README.md" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["test/{{nested-dirs}}_test.clj" (render "test_core.clj" data)]
             ["src/{{repl-file}}.clj" (render "repl.clj" data)]
             ["src/{{nested-dirs}}.clj" (render "core.clj" data)])))
