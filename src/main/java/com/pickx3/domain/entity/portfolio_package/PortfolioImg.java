package com.pickx3.domain.entity.portfolio_package;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class PortfolioImg {

    @Column(name="portfolioImgNum")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolioNum")
    private Portfolio portfolio;

    @Column(name="portfolioImgOriginName")
    private String originFilename;

    @Column(name="portfolioImgName")
    private String storeFilename;

    private String portfolioImgAddr;

    @Builder
    public PortfolioImg(Long id, Portfolio portfolio, String originFilename, String storeFilename, String portfolioImgAddr) {
        this.id = id;
        this.portfolio = portfolio;
        this.originFilename = originFilename;
        this.storeFilename = storeFilename;
        this.portfolioImgAddr = portfolioImgAddr;
    }
}
