package com.example.demo.core.exception;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

/**
 * WEB例外ハンドラー
 */
@ControllerAdvice
@RequiredArgsConstructor
public class WebExceptionHandler {

    /** メッセージ */
    private final MessageSource messages;
    /** ロガー */
    private static final Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

    /**
     * ステータス付き例外の処理
     * 該当するHTTPステータスでエラー画面へ遷移する。
     * @param e ステータス付き例外
     * @param response レスポンス
     * @param model モデル
     * @return エラー画面
     */
    @ExceptionHandler(ResponseStatusException.class)
    public String handleResponseStatusException(ResponseStatusException e, HttpServletResponse response, Model model) {
        response.setStatus(e.getStatusCode().value());
        if (e.getStatusCode().value() == 404) {
            model.addAttribute("message", messages.getMessage("ME404", null, Locale.getDefault()));
        }
        return "error";
    }

    /**
     * システム例外の処理
     * ログ出力を行い、システムエラー画面へ遷移する。
     * @param t システム例外
     * @return エラー画面
     */
    @ExceptionHandler(SystemException.class)
    public String handleSystemException(SystemException t) {
        logger.error(messages.getMessage(t.getMessageId(), null, Locale.getDefault()), t);
        return "error";
    }

    /**
     * 予期せぬ例外の処理
     * ログ出力を行い、システムエラー画面へ遷移する。
     * @param t 例外
     * @return エラー画面
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception t) {
        logger.error(t.getMessage(), t);
        return "error";
    }

}
