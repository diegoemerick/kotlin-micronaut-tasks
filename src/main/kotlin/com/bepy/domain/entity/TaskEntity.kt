package com.bepy.domain.entity

import javax.persistence.*

@Entity
@Table(name = "tb_task")
class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_seq")
    @SequenceGenerator(name = "task_id_seq", sequenceName = "task_id_seq", allocationSize = 1)
    var id: Int? = null

    @Column(name = "title", length = 100)
    var title: String = ""

    @Column(name = "status")
    var status: Int = 0

}