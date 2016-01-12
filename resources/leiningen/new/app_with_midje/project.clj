(defproject {{sanitized}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Apache V2"
            :url "https://www.apache.org/licenses/LICENSE-2.0.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [prismatic/schema "{{schema-version}}"]]
  :main ^:skip-aot {{main}}
  :target-path "target/%s"
  :repl-options {:init-ns {{repl-ns}}
                 :prompt (fn [ns] (str "{{sanitized}}"
                                       " ["
                                       ns
                                       "] > "))}
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[midje "{{midje-version}}"]]}})

