(ns leiningen.new.app-with-midje
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files
                                             multi-segment]]
            [leiningen.core.main :as main]))

(def render (renderer "app-with-midje"))

(defn app-with-midje
  "FIXME: write documentation"
  [name]
  (let [sanitized (name-to-path name)
        main (multi-segment sanitized)
        nested-dirs (name-to-path main)
        repl-ns (multi-segment sanitized "repl")
        repl-file (name-to-path repl-ns)
        midje-version "1.8.3"
        schema-version "1.0.4"
        data {:name name
              :sanitized sanitized
              :nested-dirs nested-dirs
              :repl-ns repl-ns
              :repl-file repl-file
              :main main
              :midje-version midje-version
              :schema-version schema-version}]
    (main/info "Generating fresh 'lein new' app-with-midje project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             [".gitignore" (render "gitignore" data)]
             ["README" (render "README.md" data)]
             ["test/{{nested-dirs}}_test.clj" (render "test_core.clj" data)]
             ["src/{{repl-file}}.clj" (render "repl.clj" data)]
             ["src/{{nested-dirs}}.clj" (render "core.clj" data)])))
