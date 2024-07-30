package models;

import java.time.LocalDate; // 日付を表すクラス（年、月、日）
import java.time.LocalDateTime; // 日時を表すクラス（年、月、日、時間、分、秒）

import javax.persistence.Column; // データベースのカラムをマッピングするためのアノテーション
import javax.persistence.Entity; // エンティティクラスを示すアノテーション
import javax.persistence.GeneratedValue; // プライマリキーの生成戦略を指定するアノテーション
import javax.persistence.GenerationType; // プライマリキーの生成戦略の種類を示す列挙型
import javax.persistence.Id; // プライマリキーを示すアノテーション
import javax.persistence.JoinColumn; // 外部キーのカラムを指定するアノテーション
import javax.persistence.Lob; // 大きなオブジェクト（Large Object）を扱うカラムを示すアノテーション
import javax.persistence.ManyToOne; // 多対一のリレーションシップを示すアノテーション
import javax.persistence.NamedQueries; // 複数の名前付きクエリを定義するアノテーション
import javax.persistence.NamedQuery; // 名前付きクエリを定義するアノテーション
import javax.persistence.Table; // エンティティが対応するデータベースのテーブル名を指定するアノテーション

import constants.JpaConst; // 定数クラス（JPA関連の定数を含む）
import lombok.AllArgsConstructor; // 全フィールドを引数に持つコンストラクタを自動生成するアノテーション
import lombok.Getter; // クラスの全フィールドに対してgetterメソッドを自動生成するアノテーション
import lombok.NoArgsConstructor; // 引数なしのコンストラクタを自動生成するアノテーション
import lombok.Setter; // クラスの全フィールドに対してsetterメソッドを自動生成するアノテーション

/**
 * 日報データのDTOモデル
 *
 */
@Table(name = JpaConst.TABLE_REP)
@NamedQueries({
        @NamedQuery(name = JpaConst.Q_REP_GET_ALL, query = JpaConst.Q_REP_GET_ALL_DEF),
        @NamedQuery(name = JpaConst.Q_REP_COUNT, query = JpaConst.Q_REP_COUNT_DEF),
        @NamedQuery(name = JpaConst.Q_REP_GET_ALL_MINE, query = JpaConst.Q_REP_GET_ALL_MINE_DEF),
        @NamedQuery(name = JpaConst.Q_REP_COUNT_ALL_MINE, query = JpaConst.Q_REP_COUNT_ALL_MINE_DEF)
})

@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
@Entity
public class Report {

    /**
     * id
     */
    @Id
    @Column(name = JpaConst.REP_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 日報を登録した従業員
     */
    @ManyToOne
    @JoinColumn(name = JpaConst.REP_COL_EMP, nullable = false)
    private Employee employee;

    /**
     * いつの日報かを示す日付
     */
    @Column(name = JpaConst.REP_COL_REP_DATE, nullable = false)
    private LocalDate reportDate;

    /**
     * 日報のタイトル
     */
    @Column(name = JpaConst.REP_COL_TITLE, length = 255, nullable = false)
    private String title;

    /**
     * 日報の内容
     */
    @Lob
    @Column(name = JpaConst.REP_COL_CONTENT, nullable = false)
    private String content;

    /**
     * 登録日時
     */
    @Column(name = JpaConst.REP_COL_CREATED_AT, nullable = false)
    private LocalDateTime createdAt;

    /**
     * 更新日時
     */
    @Column(name = JpaConst.REP_COL_UPDATED_AT, nullable = false)
    private LocalDateTime updatedAt;

}